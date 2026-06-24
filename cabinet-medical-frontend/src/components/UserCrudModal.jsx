import {

    useState

} from "react";

import {

    useTranslation

} from "react-i18next";

import "../styles/UserCrudModal.css";

function UserCrudModal({

                           user,

                           doctors,

                           patients,

                           onSave,

                           onDelete,

                           onClose

                       }) {

    const {

        t

    } = useTranslation();

    const [

        username,

        setUsername

    ] = useState(

        user?.username || ""

    );

    const [

        password,

        setPassword

    ] = useState(

        user?.password || ""

    );

    const [

        email,

        setEmail

    ] = useState(

        user?.email || ""

    );

    const [

        phone,

        setPhone

    ] = useState(

        user?.phone || ""

    );

    const [

        role,

        setRole

    ] = useState(

        user?.role || "PATIENT"

    );

    const [

        doctorId,

        setDoctorId

    ] = useState(

        user?.doctorId || ""

    );

    const [

        patientId,

        setPatientId

    ] = useState(

        user?.patientId || ""

    );

    const handleSave =
        () => {

            onSave({

                ...user,

                username,

                password,

                email,

                phone,

                role,

                doctorId:

                    role === "DOCTOR"

                        ?

                        Number(

                            doctorId

                        )

                        :

                        null,

                patientId:

                    role === "PATIENT"

                        ?

                        Number(

                            patientId

                        )

                        :

                        null,

                assistantId: null

            });
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

                    {t("users")}

                </h2>

                <input

                    placeholder={

                        t("username")

                    }

                    value={username}

                    onChange={

                        e =>

                            setUsername(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder={

                        t("password")

                    }

                    value={password}

                    onChange={

                        e =>

                            setPassword(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder={

                        t("email")

                    }

                    value={email}

                    onChange={

                        e =>

                            setEmail(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder={

                        t("phone")

                    }

                    value={phone}

                    onChange={

                        e =>

                            setPhone(

                                e.target.value

                            )

                    }

                />

                <select

                    value={role}

                    onChange={

                        e =>

                            setRole(

                                e.target.value

                            )

                    }

                >

                    <option value="ADMIN">

                        ADMIN

                    </option>

                    <option value="DOCTOR">

                        DOCTOR

                    </option>

                    <option value="ASSISTANT">

                        ASSISTANT

                    </option>

                    <option value="PATIENT">

                        PATIENT

                    </option>

                </select>

                {

                    role === "DOCTOR" && (

                        <select

                            value={doctorId}

                            onChange={

                                e =>

                                    setDoctorId(

                                        e.target.value

                                    )

                            }

                        >

                            <option value="">

                                Selectează doctor

                            </option>

                            {

                                doctors.map(

                                    doctor => (

                                        <option

                                            key={doctor.id}

                                            value={doctor.id}

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

                }

                {

                    role === "PATIENT" && (

                        <select

                            value={patientId}

                            onChange={

                                e =>

                                    setPatientId(

                                        e.target.value

                                    )

                            }

                        >

                            <option value="">

                                Selectează pacient

                            </option>

                            {

                                patients.map(

                                    patient => (

                                        <option

                                            key={patient.id}

                                            value={patient.id}

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

                    )

                }

                <button

                    className="save-btn"

                    onClick={handleSave}

                >

                    {t("save")}

                </button>

                {

                    user && (

                        <button

                            className="delete-btn"

                            onClick={() =>
                                onDelete(
                                    user.id
                                )
                            }

                        >

                            {t("delete")}

                        </button>

                    )

                }

            </div>

        </div>

    );

}

export default UserCrudModal;