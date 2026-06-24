import {

    useState

} from "react";

import {

    useTranslation

} from "react-i18next";

import "../styles/DoctorCrudModal.css";

function DoctorCrudModal({

                             doctor,

                             onSave,

                             onDelete,

                             onClose

                         }) {

    const {

        t

    } = useTranslation();

    const [

        firstName,

        setFirstName

    ] = useState(

        doctor?.firstName || ""

    );

    const [

        lastName,

        setLastName

    ] = useState(

        doctor?.lastName || ""

    );

    const [

        specializationName,

        setSpecializationName

    ] = useState(

        doctor?.specializationName || ""

    );

    const [

        cv,

        setCv

    ] = useState(

        doctor?.cv || ""

    );

    const [

        photo,

        setPhoto

    ] = useState(

        doctor?.photo || ""

    );

    const handleSave =
        () => {

            onSave({

                ...doctor,

                firstName,

                lastName,

                specializationName,

                cv,

                photo

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

                    {t("doctor")}

                </h2>

                <input

                    placeholder={t("firstName")}

                    value={firstName}

                    onChange={

                        e =>

                            setFirstName(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder={t("lastName")}

                    value={lastName}

                    onChange={

                        e =>

                            setLastName(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder={t("specialization")}

                    value={specializationName}

                    onChange={

                        e =>

                            setSpecializationName(

                                e.target.value

                            )

                    }

                />

                <textarea

                    placeholder="CV"

                    value={cv}

                    onChange={

                        e =>

                            setCv(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder={t("photo")}

                    value={photo}

                    onChange={

                        e =>

                            setPhoto(

                                e.target.value

                            )

                    }

                />

                <button

                    className="save-btn"

                    onClick={handleSave}

                >

                    {t("save")}

                </button>

                {

                    doctor && (

                        <button

                            className="delete-btn"

                            onClick={() =>
                                onDelete(
                                    doctor.id
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

export default DoctorCrudModal;