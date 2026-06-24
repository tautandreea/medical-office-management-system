import {

    useState

} from "react";

import "../styles/PatientCrudModal.css";

function PatientCrudModal({

                              patient,

                              onSave,

                              onDelete,

                              onClose

                          }) {

    const [

        firstName,

        setFirstName

    ] = useState(

        patient?.firstName || ""

    );

    const [

        lastName,

        setLastName

    ] = useState(

        patient?.lastName || ""

    );

    const [

        age,

        setAge

    ] = useState(

        patient?.age || ""

    );

    const [

        gender,

        setGender

    ] = useState(

        patient?.gender || "MALE"

    );

    const [

        email,

        setEmail

    ] = useState(

        patient?.email || ""

    );

    const [

        phone,

        setPhone

    ] = useState(

        patient?.phone || ""

    );

    const [

        cnp,

        setCnp

    ] = useState(

        patient?.cnp || ""

    );

    const handleSave =
        () => {

            onSave({

                ...patient,

                firstName,

                lastName,

                age:

                    Number(age),

                gender,

                email,

                phone,

                cnp

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

                    Pacient

                </h2>

                <input

                    placeholder="CNP"

                    value={cnp}

                    onChange={

                        e =>

                            setCnp(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder="Prenume"

                    value={firstName}

                    onChange={

                        e =>

                            setFirstName(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder="Nume"

                    value={lastName}

                    onChange={

                        e =>

                            setLastName(

                                e.target.value

                            )

                    }

                />

                <input

                    type="number"

                    placeholder="Vârstă"

                    value={age}

                    onChange={

                        e =>

                            setAge(

                                e.target.value

                            )

                    }

                />

                <select

                    value={gender}

                    onChange={

                        e =>

                            setGender(

                                e.target.value

                            )

                    }

                >

                    <option value="MALE">

                        MALE

                    </option>

                    <option value="FEMALE">

                        FEMALE

                    </option>

                </select>

                <input

                    placeholder="Email"

                    value={email}

                    onChange={

                        e =>

                            setEmail(

                                e.target.value

                            )

                    }

                />

                <input

                    placeholder="Telefon"

                    value={phone}

                    onChange={

                        e =>

                            setPhone(

                                e.target.value

                            )

                    }

                />

                <button

                    className="save-btn"

                    onClick={handleSave}

                >

                    Salvează

                </button>

                {

                    patient && (

                        <button

                            className="delete-btn"

                            onClick={() =>
                                onDelete(
                                    patient.id
                                )
                            }

                        >

                            Șterge

                        </button>

                    )

                }

            </div>

        </div>

    );
}

export default PatientCrudModal;