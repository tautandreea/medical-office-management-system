/* eslint-disable react-hooks/set-state-in-effect */
import {

    useEffect,
    useState

} from "react";

import {

    useTranslation

} from "react-i18next";

import Navbar
    from "../components/Navbar";

import AssistantPatientList
    from "../components/AssistantPatientList";

import PatientCrudModal
    from "../components/PatientCrudModal";

import {

    getAllPatients,
    createPatient,
    updatePatient,
    deletePatient

} from "../services/assistantPatientService";


import {

    getAllMedicalRecords

} from "../services/doctorMedicalRecordService";
import AssistantDoctorList
    from "../components/AssistantDoctorList";

import DoctorCrudModal
    from "../components/DoctorCrudModal";

import {

    getAllDoctors,
    createDoctor,
    updateDoctor,
    deleteDoctor

} from "../services/assistantDoctorService";

import {

    getAllAppointments,
    createAppointment,
    deleteAppointment

} from "../services/appointmentService";

import {

    exportPatients,
    exportDoctors

} from "../services/exportService";

import StatisticsPanel
    from "../components/StatisticsPanel";

import "../styles/AssistantDashboard.css";


function AssistantDashboard() {

    const [

        activeSection,

        setActiveSection

    ] = useState(

        "patients"

    );

    const {

        t

    } = useTranslation();


    const [

        patients,

        setPatients

    ] = useState([]);

    const [

        doctorsList,

        setDoctorsList

    ] = useState([]);

    const [

        selectedDoctor,

        setSelectedDoctor

    ] = useState(null);

    const [

        showDoctorModal,

        setShowDoctorModal

    ] = useState(false);

    const [

        doctors,

        setDoctors

    ] = useState([]);

    const [

        medicalRecords,

        setMedicalRecords

    ] = useState([]);

    const [

        filterType,

        setFilterType

    ] = useState("");

    const [

        filterValue,

        setFilterValue

    ] = useState("");

    const [

        selectedPatient,

        setSelectedPatient

    ] = useState(null);

    const [

        searchText,

        setSearchText

    ] = useState("");

    const [

        appointments,

        setAppointments

    ] = useState([]);

    const [

        selectedAppointmentPatient,

        setSelectedAppointmentPatient

    ] = useState("");

    const [

        selectedAppointmentDoctor,

        setSelectedAppointmentDoctor

    ] = useState("");

    const [

        appointmentDate,

        setAppointmentDate

    ] = useState("");

    const loadData =
        async () => {

            try {

                const patientsData =

                    await getAllPatients();

                const doctorsData =

                    await getAllDoctors();

                const recordsData =

                    await getAllMedicalRecords();

                const appointmentsData =

                    await getAllAppointments();

                setAppointments(
                    appointmentsData
                );

                setPatients(
                    patientsData
                );

                setDoctors(
                    doctorsData
                );

                const doctorsCrudData =

                    await getAllDoctors();

                setDoctorsList(
                    doctorsCrudData
                );

                setMedicalRecords(
                    recordsData
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };

    const [

        showModal,

        setShowModal

    ] = useState(false);

    useEffect(() => {

        loadData();

    }, []);


    const handleCreatePatient =
        () => {

            setSelectedPatient(
                null
            );

            setShowModal(
                true
            );
        };

    const handleEditPatient =
        patient => {

            setSelectedPatient(
                patient
            );

            setShowModal(
                true
            );
        };

    const handleSavePatient =
        async patient => {

            try {

                if (

                    patient.id

                ) {

                    await updatePatient(
                        patient
                    );

                } else {

                    await createPatient({

                        firstName:
                        patient.firstName,

                        lastName:
                        patient.lastName,

                        age:
                        patient.age,

                        gender:
                        patient.gender,

                        email:
                        patient.email,

                        phone:
                        patient.phone,

                        cnp:
                        patient.cnp

                    });

                }

                await loadData();

                setShowModal(
                    false
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };

    const handleDeletePatient =
        async patientId => {

            const confirmed =

                window.confirm(

                    t("deletePatientConfirm")

                )

            if (!confirmed) {

                return;
            }

            try {

                await deletePatient(

                    patientId

                );

                await loadData();

                setShowModal(
                    false
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };

    const handleCreateDoctor =
        () => {

            setSelectedDoctor(
                null
            );

            setShowDoctorModal(
                true
            );
        };

    const handleEditDoctor =
        doctor => {

            setSelectedDoctor(
                doctor
            );

            setShowDoctorModal(
                true
            );
        };

    const handleSaveDoctor =
        async doctor => {

            try {

                if (

                    doctor.id

                ) {

                    await updateDoctor(
                        doctor
                    );

                } else {

                    await createDoctor({

                        firstName:
                        doctor.firstName,

                        lastName:
                        doctor.lastName,

                        specializationName:
                        doctor.specializationName,

                        cv:
                        doctor.cv,

                        photo:
                        doctor.photo

                    });

                }

                await loadData();

                setShowDoctorModal(
                    false
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };

    const handleDeleteDoctor =
        async doctorId => {

            const confirmed =

                window.confirm(

                    t("deleteDoctorConfirm")

                )

            if (!confirmed) {

                return;
            }

            try {

                await deleteDoctor(
                    doctorId
                );

                await loadData();

                setShowDoctorModal(
                    false
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };

    const handleCreateAppointment =
        async () => {

            try {

                await createAppointment({

                    patientId:

                        Number(

                            selectedAppointmentPatient

                        ),

                    doctorId:

                        Number(

                            selectedAppointmentDoctor

                        ),

                    appointmentDate

                });

                await loadData();

                setSelectedAppointmentPatient(
                    ""
                );

                setSelectedAppointmentDoctor(
                    ""
                );

                setAppointmentDate(
                    ""
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };
    const handleDeleteAppointment =
        async id => {

            await deleteAppointment(
                id
            );

            await loadData();
        };

    const downloadFile = (

        content,

        fileName

    ) => {

        const blob =

            new Blob(

                [content],

                {

                    type:
                        "text/plain"

                }

            );

        const url =

            window.URL.createObjectURL(
                blob
            );

        const a =

            document.createElement(
                "a"
            );

        a.href = url;

        a.download = fileName;

        a.click();

        window.URL.revokeObjectURL(
            url
        );
    };

    const handleExportPatients =
        async format => {

            const content =

                await exportPatients(
                    format
                );

            downloadFile(

                content,

                `patients.${format.toLowerCase()}`

            );
        };

    const handleExportDoctors =
        async format => {

            const content =

                await exportDoctors(
                    format
                );

            downloadFile(

                content,

                `doctors.${format.toLowerCase()}`

            );
        };

    let filteredPatients =
        patients;
    if (

        filterType === "age"

    ) {

        filteredPatients =

            patients.filter(

                patient =>

                    patient.age ===

                    Number(
                        filterValue
                    )

            );
    }
    if (

        filterType === "doctor"

    ) {

        const patientIds =

            [

                ...new Set(

                    medicalRecords

                        .filter(

                            record =>

                                record.doctorId ===

                                Number(
                                    filterValue
                                )

                        )

                        .map(

                            record =>

                                record.patientId

                        )

                )

            ];

        filteredPatients =

            patients.filter(

                patient =>

                    patientIds.includes(

                        patient.id

                    )

            );
    }
    if (

        filterType === "diagnosis"

    ) {

        const patientIds =

            [

                ...new Set(

                    medicalRecords

                        .filter(

                            record =>

                                record.diagnosis

                                    .toLowerCase()

                                    .includes(

                                        filterValue
                                            .toLowerCase()

                                    )

                        )

                        .map(

                            record =>

                                record.patientId

                        )

                )

            ];

        filteredPatients =

            patients.filter(

                patient =>

                    patientIds.includes(

                        patient.id

                    )

            );
    }

    if (

        searchText.trim() !== ""

    ) {

        filteredPatients =

            filteredPatients.filter(

                patient =>

                    patient.firstName

                        .toLowerCase()

                        .startsWith(

                            searchText
                                .toLowerCase()

                        )

                    ||

                    patient.lastName

                        .toLowerCase()

                        .startsWith(

                            searchText
                                .toLowerCase()

                        )

            );
    }

    return (

        <div>

            <Navbar />

            <div className="assistant-container">

                <div className="assistant-menu">

                    <button

                        className={

                            activeSection ===
                            "patients"

                                ?

                                "active"

                                :

                                ""

                        }

                        onClick={() =>

                            setActiveSection(
                                "patients"
                            )

                        }

                    >

                        {t("patients")}

                    </button>

                    <button

                        className={

                            activeSection ===
                            "doctors"

                                ?

                                "active"

                                :

                                ""

                        }

                        onClick={() =>

                            setActiveSection(
                                "doctors"
                            )

                        }

                    >

                        {t("doctors")}

                    </button>

                    <button

                        className={

                            activeSection ===
                            "appointments"

                                ?

                                "active"

                                :

                                ""

                        }

                        onClick={() =>

                            setActiveSection(
                                "appointments"
                            )

                        }

                    >

                        {t("appointments")}

                    </button>

                    <button

                        className={

                            activeSection ===
                            "export"

                                ?

                                "active"

                                :

                                ""

                        }

                        onClick={() =>

                            setActiveSection(
                                "export"
                            )

                        }

                    >

                        {t("export")}

                    </button>

                    <button

                        className={

                            activeSection ===
                            "statistics"

                                ?

                                "active"

                                :

                                ""

                        }

                        onClick={() =>

                            setActiveSection(
                                "statistics"
                            )

                        }

                    >

                        {t("statistics")}

                    </button>

                </div>

                {

                    activeSection ===
                    "patients"

                    &&

                    (

                        <div className="assistant-content">

                            <div className="content-header">

                            <h1>

                                {t("managePatients")}

                                </h1>

                                <div className="filters">

                                    <select

                                        value={filterType}

                                        onChange={

                                            e => {

                                                setFilterType(
                                                    e.target.value
                                                );

                                                setFilterValue(
                                                    ""
                                                );
                                            }

                                        }

                                    >

                                        <option value="">

                                            {t("filterBy")}

                                        </option>

                                        <option value="doctor">

                                            {t("doctor")}

                                        </option>

                                        <option value="diagnosis">

                                            {t("diagnosis")}

                                        </option>

                                        <option value="age">

                                            {t("age")}

                                        </option>

                                    </select>

                                    {

                                        filterType === "doctor"

                                            ?

                                            (

                                                <select

                                                    value={
                                                        filterValue
                                                    }

                                                    onChange={

                                                        e =>

                                                            setFilterValue(
                                                                e.target.value
                                                            )

                                                    }

                                                >

                                                    <option value="">

                                                        {t("selectDoctor")}

                                                    </option>

                                                    {

                                                        doctors.map(
                                                            doctor => (

                                                                <option

                                                                    key={
                                                                        doctor.id
                                                                    }

                                                                    value={
                                                                        doctor.id
                                                                    }

                                                                >

                                                                    {

                                                                        doctor.firstName

                                                                    }

                                                                    {" "}

                                                                    {

                                                                        doctor.lastName

                                                                    }

                                                                </option>

                                                            )
                                                        )

                                                    }

                                                </select>

                                            )

                                            :

                                            (


                                                <input

                                                    type="text"

                                                    placeholder="Valoare"

                                                    value={
                                                        filterValue
                                                    }

                                                    onChange={

                                                        e =>

                                                            setFilterValue(
                                                                e.target.value
                                                            )

                                                    }

                                                />

                                            )

                                    }
                                    <input

                                        type="text"

                                        placeholder={t("searchPatient")}

                                        value={searchText}

                                        onChange={

                                            e =>

                                                setSearchText(
                                                    e.target.value
                                                )

                                        }

                                    />


                                </div>

                                <button

                                    className="add-btn"

                                    onClick={

                                        handleCreatePatient

                                    }

                                >

                                    +

                                    + {t("addPatient")}

                                </button>

                            </div>

                            <AssistantPatientList

                                patients={
                                    filteredPatients
                                }

                                medicalRecords={
                                    medicalRecords
                                }

                                doctors={
                                    doctors
                                }

                                filterType={
                                    filterType
                                }

                                onSelect={

                                    handleEditPatient

                                }

                            />

                        </div>

                    )

                }
                {

                    activeSection ===
                    "doctors"

                    &&

                    (

                        <div className="assistant-content">

                            <div className="content-header">

                                <h1>

                                    {t("manageDoctors")}

                                </h1>

                                <button

                                    className="add-btn"

                                    onClick={

                                        handleCreateDoctor

                                    }

                                >

                                    + {t("addDoctor")}

                                </button>

                            </div>

                            <AssistantDoctorList

                                doctors={
                                    doctorsList
                                }

                                onSelect={

                                    handleEditDoctor

                                }

                            />

                        </div>

                    )

                }

                {

                    activeSection ===
                    "appointments"

                    &&

                    (

                        <div className="assistant-content">

                            <h1>

                                {t("appointmentScheduling")}

                            </h1>

                            <div className="appointment-form">

                                <select

                                    value={
                                        selectedAppointmentPatient
                                    }

                                    onChange={

                                        e =>

                                            setSelectedAppointmentPatient(

                                                e.target.value

                                            )

                                    }

                                >

                                    <option value="">

                                        {t("selectPatient")}

                                    </option>

                                    {

                                        patients.map(

                                            patient => (

                                                <option

                                                    key={
                                                        patient.id
                                                    }

                                                    value={
                                                        patient.id
                                                    }

                                                >

                                                    {

                                                        patient.firstName

                                                    }

                                                    {" "}

                                                    {

                                                        patient.lastName

                                                    }

                                                </option>

                                            )

                                        )

                                    }

                                </select>

                                <select

                                    value={
                                        selectedAppointmentDoctor
                                    }

                                    onChange={

                                        e =>

                                            setSelectedAppointmentDoctor(

                                                e.target.value

                                            )

                                    }

                                >

                                    <option value="">

                                        {t("selectDoctor")}

                                    </option>

                                    {

                                        doctorsList.map(

                                            doctor => (

                                                <option

                                                    key={
                                                        doctor.id
                                                    }

                                                    value={
                                                        doctor.id
                                                    }

                                                >

                                                    Dr.

                                                    {" "}

                                                    {

                                                        doctor.firstName

                                                    }

                                                    {" "}

                                                    {

                                                        doctor.lastName

                                                    }

                                                </option>

                                            )

                                        )

                                    }

                                </select>

                                <input

                                    type="datetime-local"

                                    value={
                                        appointmentDate
                                    }

                                    onChange={

                                        e =>

                                            setAppointmentDate(

                                                e.target.value

                                            )

                                    }

                                />

                                <button

                                    className="add-btn"

                                    onClick={

                                        handleCreateAppointment

                                    }

                                >

                                    {t("schedule")}

                                </button>

                            </div>

                            <div className="appointments-list">

                                {

                                    appointments.map(

                                        appointment => {

                                            const patient =

                                                patients.find(

                                                    p =>

                                                        p.id ===

                                                        appointment.patientId

                                                );

                                            const doctor =

                                                doctorsList.find(

                                                    d =>

                                                        d.id ===

                                                        appointment.doctorId

                                                );

                                            return (

                                                <div

                                                    key={appointment.id}

                                                    className="appointment-item"

                                                >

                                                    <div>

                                                        <strong>

                                                            {t("patient")}:

                                                        </strong>

                                                        {" "}

                                                        {

                                                            patient

                                                                ?

                                                                `${patient.firstName} ${patient.lastName}`

                                                                :

                                                                appointment.patientId

                                                        }

                                                        {" | "}

                                                        <strong>

                                                            {t("doctor")}:

                                                        </strong>

                                                        {" "}

                                                        {

                                                            doctor

                                                                ?

                                                                `Dr. ${doctor.firstName} ${doctor.lastName}`

                                                                :

                                                                appointment.doctorId

                                                        }

                                                        {" | "}

                                                        {

                                                            appointment.appointmentDate

                                                        }

                                                    </div>

                                                    <button

                                                        onClick={() =>

                                                            handleDeleteAppointment(

                                                                appointment.id

                                                            )

                                                        }

                                                    >

                                                        {t("delete")}

                                                    </button>

                                                </div>

                                            );

                                        }

                                    )

                                }

                            </div>

                        </div>

                    )

                }
                {

                    activeSection ===
                    "statistics"

                    &&

                    (

                        <div className="assistant-content">

                            <h1>

                                {t("statistics")}

                            </h1>

                            <StatisticsPanel />

                        </div>

                    )

                }

                {

                    activeSection ===
                    "export"

                    &&

                    (

                        <div className="assistant-content">

                            <h1>

                                {t("exportData")}

                            </h1>

                            <h2>

                                {t("patients")}

                            </h2>

                            <div className="export-buttons">

                                <button
                                    onClick={() =>
                                        handleExportPatients(
                                            "CSV"
                                        )
                                    }
                                >
                                    CSV
                                </button>

                                <button
                                    onClick={() =>
                                        handleExportPatients(
                                            "JSON"
                                        )
                                    }
                                >
                                    JSON
                                </button>

                                <button
                                    onClick={() =>
                                        handleExportPatients(
                                            "XML"
                                        )
                                    }
                                >
                                    XML
                                </button>

                                <button
                                    onClick={() =>
                                        handleExportPatients(
                                            "DOC"
                                        )
                                    }
                                >
                                    DOC
                                </button>

                            </div>

                            <h2>

                                {t("doctors")}

                            </h2>

                            <div className="export-buttons">

                                <button
                                    onClick={() =>
                                        handleExportDoctors(
                                            "CSV"
                                        )
                                    }
                                >
                                    CSV
                                </button>

                                <button
                                    onClick={() =>
                                        handleExportDoctors(
                                            "JSON"
                                        )
                                    }
                                >
                                    JSON
                                </button>

                                <button
                                    onClick={() =>
                                        handleExportDoctors(
                                            "XML"
                                        )
                                    }
                                >
                                    XML
                                </button>

                                <button
                                    onClick={() =>
                                        handleExportDoctors(
                                            "DOC"
                                        )
                                    }
                                >
                                    DOC
                                </button>

                            </div>

                        </div>

                    )

                }

            </div>

            {

                showModal && (

                    <PatientCrudModal

                        patient={

                            selectedPatient

                        }

                        onSave={

                            handleSavePatient

                        }

                        onDelete={

                            handleDeletePatient

                        }

                        onClose={() =>

                            setShowModal(
                                false
                            )

                        }

                    />

                )

            }
            {

                showDoctorModal

                &&

                (

                    <DoctorCrudModal

                        doctor={
                            selectedDoctor
                        }

                        onSave={
                            handleSaveDoctor
                        }

                        onDelete={
                            handleDeleteDoctor
                        }

                        onClose={() =>

                            setShowDoctorModal(
                                false
                            )

                        }

                    />

                )

            }

        </div>

    );
}

export default AssistantDashboard;