import {

    useEffect,
    useState

} from "react";

import {

    useTranslation

} from "react-i18next";

import UserList
    from "../components/UserList";

import UserCrudModal
    from "../components/UserCrudModal";

import Navbar from "../components/Navbar";

import {

    getAllUsers,

    createUser,

    updateUser,

    deleteUser

} from "../services/userService";

import {

    getAllDoctors

} from "../services/doctorService";

import {

    getAllPatients

} from "../services/patientService";

import {

    exportUsers

} from "../services/exportService";

import {

    sendNotification

} from "../services/notificationService";

import "../styles/AdminDashboard.css";

function AdminDashboard() {

    const {

        t

    } = useTranslation();

    const [

        users,

        setUsers

    ] = useState([]);

    const [

        doctors,

        setDoctors

    ] = useState([]);

    const [

        patients,

        setPatients

    ] = useState([]);

    const [

        selectedUser,

        setSelectedUser

    ] = useState(null);

    const [

        showModal,

        setShowModal

    ] = useState(false);

    const [

        selectedRole,

        setSelectedRole

    ] = useState("ALL");

    const [

        searchText,

        setSearchText

    ] = useState("");

    const [

        notificationMessage,

        setNotificationMessage

    ] = useState("");

    const [

        notificationResult,

        setNotificationResult

    ] = useState("");

    useEffect(() => {

        loadUsers();

    }, []);

    async function loadUsers() {

        const usersData =
            await getAllUsers();

        const doctorsData =
            await getAllDoctors();

        const patientsData =
            await getAllPatients();

        setUsers(
            usersData
        );

        setDoctors(
            doctorsData
        );

        setPatients(
            patientsData
        );
    }

    const handleSaveUser =
        async user => {

            if (user.id) {

                await updateUser(
                    user
                );

            } else {

                await createUser(
                    user
                );
            }

            await loadUsers();

            setShowModal(
                false
            );

            setSelectedUser(
                null
            );
        };

    const handleDeleteUser =
        async id => {

            if (

                !window.confirm(

                    t(

                        "deleteUserConfirm"

                    )

                )

            ) {

                return;
            }

            await deleteUser(
                id
            );

            await loadUsers();

            setShowModal(
                false
            );

            setSelectedUser(
                null
            );
        };

    const handleExportUsers =
        async () => {

            try {

                const content =
                    await exportUsers();

                const blob =
                    new Blob(

                        [content],

                        {

                            type:
                                "text/csv"

                        }

                    );

                const url =
                    window.URL.createObjectURL(
                        blob
                    );

                const link =
                    document.createElement(
                        "a"
                    );

                link.href =
                    url;

                link.download =
                    "users.csv";

                link.click();

                window.URL.revokeObjectURL(
                    url
                );

            } catch (error) {

                console.error(
                    error
                );
            }
        };

    const handleSendEmail =
        async () => {

            if (!selectedUser)
                return;

            const result =
                await sendNotification({

                    type:
                        "EMAIL",

                    email:
                    selectedUser.email,

                    message:
                    notificationMessage
                });

            setNotificationResult(
                result.message
            );
        };

    const handleSendSms =
        async () => {

            if (!selectedUser)
                return;

            const result =
                await sendNotification({

                    type:
                        "SMS",

                    phoneNumber:
                    selectedUser.phone,

                    message:
                    notificationMessage
                });

            setNotificationResult(
                result.message
            );
        };

    let filteredUsers =

        users;

    if (

        selectedRole !==

        "ALL"

    ) {

        filteredUsers =

            filteredUsers.filter(

                user =>

                    user.role ===

                    selectedRole

            );
    }

    if (

        searchText

    ) {

        filteredUsers =

            filteredUsers.filter(

                user =>

                    user.username

                        .toLowerCase()

                        .startsWith(

                            searchText

                                .toLowerCase()

                        )

            );
    }

    return (
        <>
        <Navbar />

            <div className="admin-dashboard">

                <div className="admin-sidebar">

                    <button
                        className="active"
                    >

                        {

                            t(
                                "users"
                            )

                        }

                    </button>

                </div>

                <div className="admin-content">

                    <h1>

                        {

                            t(
                                "manageUsers"
                            )

                        }

                    </h1>


                    <div className="admin-filters">

                        <select

                            value={

                                selectedRole

                            }

                            onChange={

                                e =>

                                    setSelectedRole(
                                        e.target.value
                                    )

                            }

                        >

                            <option
                                value="ALL"
                            >

                                {

                                    t(
                                        "all"
                                    )

                                }

                            </option>

                            <option
                                value="ADMIN"
                            >

                                ADMIN

                            </option>

                            <option
                                value="DOCTOR"
                            >

                                DOCTOR

                            </option>

                            <option
                                value="ASSISTANT"
                            >

                                ASSISTANT

                            </option>

                            <option
                                value="PATIENT"
                            >

                                PATIENT

                            </option>

                        </select>

                        <input

                            type="text"

                            placeholder={

                                t(
                                    "searchUser"
                                )

                            }

                            value={

                                searchText

                            }

                            onChange={

                                e =>

                                    setSearchText(
                                        e.target.value
                                    )

                            }

                        />

                        <button

                            onClick={() => {

                                setSelectedUser(
                                    null
                                );

                                setShowModal(
                                    true
                                );
                            }}

                        >

                            +

                            {" "}

                            {

                                t(
                                    "addUser"
                                )

                            }

                        </button>

                        <button

                            className="export-btn"

                            onClick={

                                handleExportUsers

                            }

                        >

                            Export CSV

                        </button>

                    </div>

                    <div className="admin-main-content">

                        <UserList

                            users={filteredUsers}

                            onSelect={

                                user => {

                                    setSelectedUser(user);

                                }

                            }

                            onEdit={

                                user => {

                                    setSelectedUser(user);

                                    setShowModal(true);

                                }

                            }

                        />

                        <div className="notification-panel">

                            <h2>

                                Notificări

                            </h2>

                            {

                                selectedUser && (

                                    <>

                                        <p>

                                            Utilizator:

                                            {" "}

                                            <strong>

                                                {

                                                    selectedUser.username

                                                }

                                            </strong>

                                        </p>

                                        <textarea

                                            placeholder="Mesaj"

                                            value={
                                                notificationMessage
                                            }

                                            onChange={

                                                e =>

                                                    setNotificationMessage(
                                                        e.target.value
                                                    )

                                            }

                                        />

                                        <div
                                            className="notification-buttons"
                                        >

                                            <button

                                                onClick={
                                                    handleSendEmail
                                                }

                                            >

                                                Email

                                            </button>

                                            <button

                                                onClick={
                                                    handleSendSms
                                                }

                                            >

                                                SMS

                                            </button>

                                        </div>

                                        <p>

                                            {

                                                notificationResult

                                            }

                                        </p>

                                    </>

                                )

                            }

                        </div>

                    </div>

                    {

                        showModal && (

                            <UserCrudModal

                                user={

                                    selectedUser

                                }

                                doctors={

                                    doctors

                                }

                                patients={

                                    patients

                                }

                                onSave={

                                    handleSaveUser

                                }

                                onDelete={

                                    handleDeleteUser

                                }

                                onClose={() => {

                                    setShowModal(
                                        false
                                    );

                                    setSelectedUser(
                                        null
                                    );
                                }}

                            />

                        )

                    }

                </div>

            </div>

        </>

    );

}

export default AdminDashboard;