import {

    useEffect,
    useState

} from "react";

import {

    useTranslation

} from "react-i18next";

import Navbar
    from "../components/Navbar";

import DoctorPatientList
    from "../components/DoctorPatientList";

import DoctorMedicalRecordList
    from "../components/DoctorMedicalRecordList";

import MedicalRecordEditModal
    from "../components/MedicalRecordEditModal";

import DoctorScheduleModal
    from "../components/DoctorScheduleModal";

import {

    getMedicalRecordsByDoctorId,
    updateMedicalRecord

} from "../services/doctorMedicalRecordService";

import {

    getPatientById

} from "../services/patientService";

import "../styles/DoctorDashboard.css";

function DoctorDashboard() {

    const { t } =
        useTranslation();

    const [

        records,

        setRecords

    ] = useState([]);

    const [

        patients,

        setPatients

    ] = useState([]);

    const [

        selectedPatient,

        setSelectedPatient

    ] = useState(null);

    const [

        selectedRecord,

        setSelectedRecord

    ] = useState(null);

    const [

        showSchedule,

        setShowSchedule

    ] = useState(false);

    const [

        filterType,

        setFilterType

    ] = useState("name");

    const [

        searchText,

        setSearchText

    ] = useState("");

    useEffect(() => {

        const loadData =
            async () => {

                try {

                    const user =
                        JSON.parse(

                            localStorage.getItem(
                                "user"
                            )

                        );

                    if (

                        !user ||

                        !user.doctorId

                    ) {

                        return;
                    }

                    const recordsData =

                        await getMedicalRecordsByDoctorId(

                            user.doctorId

                        );

                    setRecords(
                        recordsData
                    );

                    const patientIds =

                        [

                            ...new Set(

                                recordsData.map(

                                    record =>

                                        record.patientId

                                )

                            )

                        ];

                    const patientData = [];

                    for (

                        const id of patientIds

                        ) {

                        try {

                            const patient =

                                await getPatientById(
                                    id
                                );

                            if (patient) {

                                patientData.push(
                                    patient
                                );
                            }

                        } catch (error) {

                            console.error(
                                error
                            );
                        }
                    }

                    setPatients(
                        patientData
                    );

                    if (

                        patientData.length > 0

                    ) {

                        setSelectedPatient(

                            patientData[0]

                        );
                    }

                } catch (error) {

                    console.error(
                        error
                    );
                }
            };

        loadData();

    }, []);

    const handleSaveRecord =
        async (

            updatedRecord

        ) => {

            try {

                await updateMedicalRecord(

                    updatedRecord

                );

                const user =
                    JSON.parse(

                        localStorage.getItem(
                            "user"
                        )

                    );

                const refreshedRecords =

                    await getMedicalRecordsByDoctorId(

                        user.doctorId

                    );

                setRecords(
                    refreshedRecords
                );

                setSelectedRecord(
                    null
                );

            } catch (error) {

                console.error(
                    error
                );

                alert(

                    t(
                        "medicalRecordUpdateError"
                    )

                );
            }
        };

    const filteredPatients =

        patients.filter(

            patient => {

                const text =
                    searchText
                        .toLowerCase();

                if (

                    filterType ===
                    "name"

                ) {

                    return (

                        patient.firstName
                            .toLowerCase()
                            .startsWith(text)

                        ||

                        patient.lastName
                            .toLowerCase()
                            .startsWith(text)

                    );
                }

                const patientRecords =

                    records.filter(

                        record =>

                            record.patientId ===

                            patient.id

                    );

                if (

                    filterType ===
                    "diagnosis"

                ) {

                    return patientRecords.some(

                        record =>

                            record.diagnosis

                                .toLowerCase()

                                .includes(text)

                    );
                }

                if (

                    filterType ===
                    "treatment"

                ) {

                    return patientRecords.some(

                        record =>

                            record.treatment

                                .toLowerCase()

                                .includes(text)

                    );
                }

                return true;
            }

        );

    return (

        <div>

            <Navbar />

            <div className="doctor-actions">

                <button

                    className="schedule-btn"

                    onClick={() =>

                        setShowSchedule(
                            true
                        )

                    }

                >

                    {

                        t(
                            "mySchedule"
                        )

                    }

                </button>

            </div>

            <div className="doctor-filters">

                <select

                    value={filterType}

                    onChange={

                        e =>

                            setFilterType(
                                e.target.value
                            )

                    }

                >

                    <option value="name">

                        {

                            t(
                                "name"
                            )

                        }

                    </option>

                    <option value="diagnosis">

                        {

                            t(
                                "diagnosis"
                            )

                        }

                    </option>

                    <option value="treatment">

                        {

                            t(
                                "treatment"
                            )

                        }

                    </option>

                </select>

                <input

                    type="text"

                    placeholder={

                        t(
                            "search"
                        )

                    }

                    value={searchText}

                    onChange={

                        e =>

                            setSearchText(
                                e.target.value
                            )

                    }

                />

            </div>

            <div className="doctor-layout">

                <DoctorPatientList

                    patients={
                        filteredPatients
                    }

                    selectedPatient={
                        selectedPatient
                    }

                    onSelect={
                        setSelectedPatient
                    }

                />

                <DoctorMedicalRecordList

                    records={
                        records
                    }

                    selectedPatient={
                        selectedPatient
                    }

                    onSelectRecord={
                        setSelectedRecord
                    }

                />

            </div>

            {

                selectedRecord && (

                    <MedicalRecordEditModal

                        record={
                            selectedRecord
                        }

                        onClose={() =>

                            setSelectedRecord(
                                null
                            )

                        }

                        onSave={
                            handleSaveRecord
                        }

                    />

                )

            }

            {

                showSchedule && (

                    <DoctorScheduleModal

                        doctorId={

                            JSON.parse(

                                localStorage.getItem(
                                    "user"
                                )

                            ).doctorId

                        }

                        onClose={() =>

                            setShowSchedule(
                                false
                            )

                        }

                    />

                )

            }

        </div>

    );
}

export default DoctorDashboard;