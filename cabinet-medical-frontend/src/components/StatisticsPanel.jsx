import {

    useEffect,
    useState

} from "react";

import {

    Bar

} from "react-chartjs-2";

import {

    useTranslation

} from "react-i18next";

import {

    Chart as ChartJS,

    CategoryScale,

    LinearScale,

    BarElement,

    Title,

    Tooltip,

    Legend

} from "chart.js";

import {

    getStatistics

} from "../services/statisticsService";

ChartJS.register(

    CategoryScale,

    LinearScale,

    BarElement,

    Title,

    Tooltip,

    Legend

);

function StatisticsPanel() {
    const {

        t

    } = useTranslation();

    const [

        diagnosisStats,

        setDiagnosisStats

    ] = useState([]);

    const [

        ageStats,

        setAgeStats

    ] = useState([]);

    const [

        appointmentStats,

        setAppointmentStats

    ] = useState([]);

    useEffect(() => {

        const loadStatistics =
            async () => {

                try {

                    const diagnosisData =

                        await getStatistics(

                            "PATIENTS_BY_DIAGNOSIS"

                        );

                    const ageData =

                        await getStatistics(

                            "PATIENTS_BY_AGE_GROUP"

                        );

                    const appointmentData =

                        await getStatistics(

                            "APPOINTMENTS_PER_DOCTOR"

                        );

                    console.log(

                        "Diagnosis Stats:",

                        diagnosisData

                    );

                    console.log(

                        "Age Stats:",

                        ageData

                    );

                    console.log(

                        "Appointment Stats:",

                        appointmentData

                    );

                    setDiagnosisStats(

                        diagnosisData || []

                    );

                    setAgeStats(

                        ageData || []

                    );

                    setAppointmentStats(

                        appointmentData || []

                    );

                } catch (error) {

                    console.error(

                        error

                    );
                }
            };

        loadStatistics();

    }, []);

    return (

        <div>

            <h2>

                {t("patientsByDiagnosis")}

            </h2>

            <Bar

                data={{

                    labels:

                        diagnosisStats.map(
                            item =>

                                item.diagnostic
                        ),

                    datasets: [

                        {

                            label: t("patients"),

                            data:

                                diagnosisStats.map(
                                    item => item.count
                                ),

                            backgroundColor: [

                                "#3498db",
                                "#2ecc71",
                                "#f39c12",
                                "#e74c3c",
                                "#9b59b6",
                                "#1abc9c"

                            ],

                            borderColor: "#2c3e50",

                            borderWidth: 1

                        }

                    ]

                }}

            />

            <h2>

                {t("patientsByAgeGroup")}

            </h2>

            <Bar

                data={{

                    labels:

                        ageStats.map(
                            item =>

                                item.ageGroup
                        ),

                    datasets: [

                        {

                            label: "Pacienți",

                            data:

                                ageStats.map(
                                    item => item.count
                                ),

                            backgroundColor: [

                                "#27ae60",
                                "#3498db",
                                "#f39c12",
                                "#e74c3c"

                            ],

                            borderColor: "#2c3e50",

                            borderWidth: 1

                        }

                    ]

                }}

            />

            <h2>

                {t("appointmentsPerDoctor")}

            </h2>

            <Bar

                data={{

                    labels:

                        appointmentStats.map(
                            item =>

                                item.doctorName
                        ),

                    datasets: [

                        {

                            label: t("appointments"),

                            data:

                                appointmentStats.map(
                                    item => item.appointments
                                ),

                            backgroundColor: [

                                "#8e44ad",
                                "#3498db",
                                "#16a085",
                                "#f39c12",
                                "#e74c3c"

                            ],

                            borderColor: "#2c3e50",

                            borderWidth: 1

                        }

                    ]

                }}

            />

        </div>

    );
}

export default StatisticsPanel;