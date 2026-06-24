import {

    useEffect,
    useState

} from "react";

import {

    useTranslation

} from "react-i18next";

import {

    getScheduleByDoctorId

} from "../services/scheduleService";

import "../styles/DoctorDetailsModal.css";

function DoctorDetailsModal({

                                doctor,

                                onClose

                            }) {

    const { t } =
        useTranslation();

    const [

        schedules,

        setSchedules

    ] = useState([]);

    useEffect(() => {

        const loadSchedule =
            async () => {

                try {

                    const data =
                        await getScheduleByDoctorId(
                            doctor.id
                        );

                    setSchedules(
                        data
                    );

                } catch (error) {

                    console.error(
                        error
                    );
                }
            };

        if (doctor) {

            loadSchedule();
        }

    }, [doctor]);

    if (!doctor) {

        return null;
    }

    return (

        <div className="modal-overlay">

            <div className="modal-content">

                <button

                    className="close-btn"

                    onClick={onClose}

                >

                    X

                </button>

                <h2>

                    {doctor.firstName}

                    {" "}

                    {doctor.lastName}

                </h2>

                <img

                    src={`/images/${doctor.photo}`}

                    alt="doctor"

                    className="doctor-image"

                />

                <div className="doctor-section">

                    <h3>

                        {t("curriculumVitae")}

                    </h3>

                    <p>

                        {doctor.cv}

                    </p>

                </div>

                <div className="doctor-section">

                    <h3>

                        {t("workingSchedule")}

                    </h3>

                    {

                        schedules.length > 0

                            ? (

                                schedules.map(

                                    schedule => (

                                        <div

                                            key={
                                                schedule.scheduleId
                                            }

                                            className="schedule-item"

                                        >

                                            <strong>

                                                {
                                                    schedule.dayOfWeek
                                                }

                                            </strong>

                                            {" : "}

                                            {
                                                schedule.startTime
                                            }

                                            {" - "}

                                            {
                                                schedule.endTime
                                            }

                                        </div>

                                    )

                                )

                            )

                            : (

                                <p>

                                    {t("noSchedule")}

                                </p>

                            )

                    }

                </div>

            </div>

        </div>

    );
}

export default DoctorDetailsModal;