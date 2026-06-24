import { useTranslation }
    from "react-i18next";

import LanguageSwitcher
    from "./LanguageSwitcher";

import "../styles/Navbar.css";

function Navbar({

                    onLoginClick

                }) {

    const { t } =
        useTranslation();

    const user =
        JSON.parse(
            localStorage.getItem(
                "user"
            )
        );

    const handleLogout =
        () => {

            localStorage.removeItem(
                "user"
            );

            window.location.href =
                "/";
        };

    return (

        <nav className="navbar">

            <div className="logo">

                🏥 Medical Cabinet

            </div>

            <div className="navbar-right">

                <LanguageSwitcher />

                {

                    user ? (

                        <>

                            <span
                                className="user-info"
                            >

                                {user.username}

                                {" ("}

                                {user.role}

                                {")"}

                            </span>

                            <button

                                className="logout-btn"

                                onClick={
                                    handleLogout
                                }

                            >

                                Logout

                            </button>

                        </>

                    ) : (

                        <button

                            className="login-btn"

                            onClick={
                                onLoginClick
                            }

                        >

                            {t("login")}

                        </button>

                    )

                }

            </div>

        </nav>

    );
}

export default Navbar;