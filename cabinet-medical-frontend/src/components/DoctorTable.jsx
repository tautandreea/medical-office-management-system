import { useTranslation }
    from "react-i18next";

import DoctorSearch
    from "./DoctorSearch";

import "../styles/DoctorTable.css";

function DoctorTable({

                         doctors,

                         selectedSpecialization,

                         searchTerm,

                         setSearchTerm,

                         onSelectDoctor

                     }) {

    const { t } =
        useTranslation();

    let filteredDoctors =
        doctors;

    if (selectedSpecialization) {

        filteredDoctors =
            filteredDoctors.filter(

                doctor =>

                    doctor.specializationId ===

                    selectedSpecialization.specializationId

            );
    }

    filteredDoctors =
        filteredDoctors.filter(

            doctor =>

                doctor.firstName
                    .toLowerCase()
                    .startsWith(
                        searchTerm.toLowerCase()
                    )

                ||

                doctor.lastName
                    .toLowerCase()
                    .startsWith(
                        searchTerm.toLowerCase()
                    )

        );

    return (

        <div className="doctor-panel">

            <h2>

                {

                    selectedSpecialization

                        ?

                        t("availableDoctors")

                        :

                        t("doctorList")

                }

            </h2>

            <DoctorSearch

                searchTerm={
                    searchTerm
                }

                setSearchTerm={
                    setSearchTerm
                }

            />

            {

                !selectedSpecialization &&

                searchTerm.trim() === ""

                    ?

                    (

                        <p className="doctor-placeholder">

                            {t(
                                "selectSpecializationDoctors"
                            )}

                        </p>

                    )

                    :

                    (

                        filteredDoctors.length === 0

                            ?

                            (

                                <p className="doctor-placeholder">

                                    {t(
                                        "noDoctors"
                                    )}

                                </p>

                            )

                            :

                            (

                                <div className="doctor-list">

                                    {

                                        filteredDoctors.map(

                                            doctor => (

                                                <div

                                                    key={
                                                        doctor.id
                                                    }

                                                    className="doctor-card"

                                                    onClick={() =>
                                                        onSelectDoctor(
                                                            doctor
                                                        )
                                                    }

                                                >

                                                    <span className="doctor-name">

                                                        {
                                                            doctor.firstName
                                                        }

                                                        {" "}

                                                        {
                                                            doctor.lastName
                                                        }

                                                    </span>

                                                </div>

                                            )

                                        )

                                    }

                                </div>

                            )

                    )

            }

        </div>

    );
}

export default DoctorTable;