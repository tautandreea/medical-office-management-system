import {

    useState

} from "react";

import {

    useNavigate

} from "react-router-dom";

import {

    login

} from "../services/authService";

import "../styles/LoginModal.css";

function LoginModal({

                        onClose

                    }) {

    const [

        username,

        setUsername

    ] = useState("");

    const [

        password,

        setPassword

    ] = useState("");

    const navigate =
        useNavigate();

    const handleLogin =
        async () => {

            try {

                const user =
                    await login(

                        username,

                        password

                    );

                localStorage.setItem(

                    "user",

                    JSON.stringify(
                        user
                    )

                );

                if (

                    user.role ===
                    "ADMIN"

                ) {

                    navigate(
                        "/admin"
                    );
                }

                else if (

                    user.role ===
                    "DOCTOR"

                ) {

                    navigate(
                        "/doctor"
                    );
                }

                else if (

                    user.role ===
                    "ASSISTANT"

                ) {

                    navigate(
                        "/assistant"
                    );
                }

                else if (

                    user.role ===
                    "PATIENT"

                ) {

                    navigate(
                        "/patient"
                    );
                }

            }

            catch(error) {

                alert(
                    "Username sau parolă greșită!"
                );
            }
        };

    return (

        <div className="login-overlay">

            <div className="login-modal">

                <button

                    className="close-btn"

                    onClick={onClose}

                >

                    X

                </button>

                <h2>

                    Login

                </h2>

                <input

                    type="text"

                    placeholder="Username"

                    value={username}

                    onChange={(e) =>

                        setUsername(
                            e.target.value
                        )

                    }

                />

                <input

                    type="password"

                    placeholder="Password"

                    value={password}

                    onChange={(e) =>

                        setPassword(
                            e.target.value
                        )

                    }

                />

                <button

                    className="login-submit"

                    onClick={handleLogin}

                >

                    Login

                </button>

            </div>

        </div>

    );
}

export default LoginModal;