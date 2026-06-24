import {

    useEffect,
    useState

} from "react";

import {

    useTranslation

} from "react-i18next";

import {

    getScheduleByDoctorId,
    updateSchedule,
    createSchedule,
    deleteSchedule

} from "../services/doctorScheduleService";

import {

    getAppointmentsByDoctorId

} from "../services/appointmentService";

import "../styles/DoctorScheduleModal.css";

function DoctorScheduleModal({

                                 doctorId,

                                 onClose

                             }) {
    const { t } =
        useTranslation();

    const [

        schedules,

        setSchedules

    ] = useState([]);

    const [

        appointments,

        setAppointments

    ] = useState([]);

    const [

        newDay,

        setNewDay

    ] = useState("MONDAY");

    const [

        newStart,

        setNewStart

    ] = useState("");

    const [

        newEnd,

        setNewEnd

    ] = useState("");

    useEffect(() => {

        const loadData =
            async () => {

                const scheduleData =

                    await getScheduleByDoctorId(
                        doctorId
                    );

                const appointmentData =

                    await getAppointmentsByDoctorId(
                        doctorId
                    );

                setSchedules(
                    scheduleData
                );

                setAppointments(
                    appointmentData
                );
            };

        loadData();

    }, [doctorId]);

    const handleChange = (

        index,

        field,

        value

    ) => {

        const updated =
            [...schedules];

        updated[index] = {

            ...updated[index],

            [field]: value

        };

        setSchedules(
            updated
        );
    };

    const handleSave =
        async () => {

            try {

                for (

                    const schedule of schedules

                    ) {

                    await updateSchedule(
                        schedule
                    );
                }

                alert(
                    t(
                        "scheduleUpdated"
                    )
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };

    const handleAddSchedule =
        async () => {

            try {

                console.log({

                    doctorId,

                    dayOfWeek: newDay,

                    startTime: newStart,

                    endTime: newEnd

                });

                const result =

                    await createSchedule({

                        doctorId,

                        dayOfWeek: newDay,

                        startTime: newStart,

                        endTime: newEnd

                    });

                console.log(
                    "RESULT:",
                    result
                );

                if (!result) {

                    alert(
                        t(
                            "scheduleAddError"
                        )
                    );

                    return;
                }

                const refreshed =

                    await getScheduleByDoctorId(
                        doctorId
                    );

                setSchedules(
                    refreshed
                );

                setNewDay("MONDAY");
                setNewStart("");
                setNewEnd("");

            } catch (error) {

                console.error(error);
            }
        };

    const handleDeleteSchedule =
        async (

            scheduleId

        ) => {

            const confirmed =

                window.confirm(

                    t(
                        "deleteScheduleConfirm"
                    )

                );

            if (!confirmed) {

                return;
            }

            try {

                const result =

                    await deleteSchedule(

                        scheduleId

                    );

                if (!result) {

                    alert(
                        t(
                            "scheduleDeleteError"
                        )
                    );

                    return;
                }

                const refreshed =

                    await getScheduleByDoctorId(

                        doctorId

                    );

                setSchedules(
                    refreshed
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };

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

                    {

                        t(
                            "mySchedule"
                        )

                    }

                </h2>

                {

                    schedules.map(
                        (
                            schedule,
                            index
                        ) => (

                            <div

                                key={
                                    schedule.scheduleId
                                }

                                className="schedule-row"

                            >

                                <strong>

                                    {
                                        schedule.dayOfWeek
                                    }

                                </strong>

                                <input

                                    type="time"

                                    value={
                                        schedule.startTime
                                    }

                                    onChange={

                                        e =>

                                            handleChange(
                                                index,

                                                "startTime",

                                                e.target.value
                                            )

                                    }

                                />

                                <input

                                    type="time"

                                    value={
                                        schedule.endTime
                                    }

                                    onChange={

                                        e =>

                                            handleChange(
                                                index,

                                                "endTime",

                                                e.target.value
                                            )

                                    }

                                />

                                <button

                                    className="delete-schedule-btn"

                                    onClick={() =>

                                        handleDeleteSchedule(
                                            schedule.scheduleId
                                        )

                                    }

                                >

                                    🗑

                                </button>

                            </div>

                        )
                    )

                }

                <button

                    className="save-btn"

                    onClick={handleSave}

                >

                    {

                        t(
                            "save"
                        )

                    }

                </button>

                <hr/>

                <h2>

                    {

                        t(
                            "addSchedule"
                        )

                    }

                </h2>

                <div className="schedule-row">

                    <select

                        value={newDay}

                        onChange={

                            e =>

                                setNewDay(
                                    e.target.value
                                )

                        }

                    >

                        <option>

                            MONDAY

                        </option>

                        <option>

                            TUESDAY

                        </option>

                        <option>

                            WEDNESDAY

                        </option>

                        <option>

                            THURSDAY

                        </option>

                        <option>

                            FRIDAY

                        </option>

                    </select>

                    <input

                        type="time"

                        value={newStart}

                        onChange={

                            e =>

                                setNewStart(
                                    e.target.value
                                )

                        }

                    />

                    <input

                        type="time"

                        value={newEnd}

                        onChange={

                            e =>

                                setNewEnd(
                                    e.target.value
                                )

                        }

                    />

                    <button

                        className="save-btn"

                        onClick={

                            handleAddSchedule

                        }

                    >

                        {

                            t(
                                "add"
                            )

                        }

                    </button>

                </div>

                <hr/>

                <h2>

                    {

                        t(
                            "myAppointments"
                        )

                    }

                </h2>

                {

                    appointments.map(
                        appointment => (

                            <div

                                key={
                                    appointment.id
                                }

                                className="appointment-item"

                            >

                                <strong>

                                    {

                                        appointment.appointmentDate

                                    }

                                </strong>

                                {" - "}

                                {

                                    t(
                                        "patientId"
                                    )

                                }

                                {" "}

                                {

                                    appointment.patientId

                                }

                                {" - "}

                                {

                                    appointment.status

                                }

                            </div>

                        )
                    )

                }

            </div>

        </div>

    );
}

export default DoctorScheduleModal;