import { useEffect, useState } from "react";

import { useTranslation }
    from "react-i18next";

import Navbar
    from "../components/Navbar";

import SpecializationList
    from "../components/SpecializationList";

import DoctorTable
    from "../components/DoctorTable";

import DoctorDetailsModal
    from "../components/DoctorDetailsModal";

import LoginModal
    from "../components/LoginModal";

import {
    getAllDoctors
} from "../services/doctorService";

import {
    getAllSpecializations
} from "../services/specializationService";

import "../styles/HomePage.css";

function HomePage() {

    const { t } =
        useTranslation();

    const [
        specializations,
        setSpecializations
    ] = useState([]);

    const [
        doctors,
        setDoctors
    ] = useState([]);

    const [
        selectedSpecialization,
        setSelectedSpecialization
    ] = useState(null);

    const [
        selectedDoctor,
        setSelectedDoctor
    ] = useState(null);

    const [
        showLogin,
        setShowLogin
    ] = useState(false);

    const [
        searchTerm,
        setSearchTerm
    ] = useState("");

    useEffect(() => {

        const loadData =
            async () => {

                try {

                    const specializationsData =
                        await getAllSpecializations();

                    const doctorsData =
                        await getAllDoctors();

                    setSpecializations(
                        specializationsData
                    );

                    setDoctors(
                        doctorsData
                    );

                } catch (error) {

                    console.error(
                        error
                    );
                }
            };

        loadData();

    }, []);

    return (

        <div className="home-page">

            <Navbar

                onLoginClick={() =>

                    setShowLogin(
                        true
                    )

                }

            />

            <div className="welcome-section">

                <h1>

                    {t("welcome")}

                </h1>

                <p>

                    {t(
                        "selectSpecialization"
                    )}

                </p>

            </div>

            <div className="content-layout">

                <SpecializationList

                    specializations={
                        specializations
                    }

                    selectedSpecialization={
                        selectedSpecialization
                    }

                    onSelect={
                        setSelectedSpecialization
                    }

                />

                <DoctorTable

                    doctors={
                        doctors
                    }

                    selectedSpecialization={
                        selectedSpecialization
                    }

                    searchTerm={
                        searchTerm
                    }

                    setSearchTerm={
                        setSearchTerm
                    }

                    onSelectDoctor={
                        setSelectedDoctor
                    }

                />

            </div>

            {

                selectedDoctor && (

                    <DoctorDetailsModal

                        doctor={
                            selectedDoctor
                        }

                        onClose={() =>
                            setSelectedDoctor(
                                null
                            )
                        }

                    />

                )

            }

            {

                showLogin && (

                    <LoginModal

                        onClose={() =>

                            setShowLogin(
                                false
                            )

                        }

                    />

                )

            }

        </div>

    );
}

export default HomePage;