import {

    useEffect,
    useState

} from "react";

import Navbar
    from "../components/Navbar";

import MedicalRecordList
    from "../components/MedicalRecordList";

import MedicalRecordDetails
    from "../components/MedicalRecordDetails";

import {

    getMedicalRecordsByPatientId

} from "../services/medicalRecordService";

import "../styles/PatientDashboard.css";

function PatientDashboard() {

    const [

        records,

        setRecords

    ] = useState([]);

    const [

        selectedRecord,

        setSelectedRecord

    ] = useState(null);

    useEffect(() => {

        const loadData =
            async () => {

                const user =
                    JSON.parse(

                        localStorage.getItem(
                            "user"
                        )

                    );

                const data =
                    await getMedicalRecordsByPatientId(

                        user.id

                    );

                setRecords(
                    data
                );

                if (

                    data.length > 0

                ) {

                    setSelectedRecord(
                        data[0]
                    );
                }
            };

        loadData();

    }, []);

    return (

        <div>

            <Navbar />

            <div className="patient-layout">

                <MedicalRecordList

                    records={
                        records
                    }

                    selectedRecord={
                        selectedRecord
                    }

                    onSelect={
                        setSelectedRecord
                    }

                />

                <MedicalRecordDetails

                    record={
                        selectedRecord
                    }

                />

            </div>

        </div>

    );
}

export default PatientDashboard;