import { useTranslation }
    from "react-i18next";

import "../styles/LanguageSwitcher.css";

function LanguageSwitcher() {

    const { i18n } =
        useTranslation();

    return (

        <div className="language-switcher">

            <button
                onClick={() =>
                    i18n.changeLanguage("ro")
                }
            >
                RO
            </button>

            <button
                onClick={() =>
                    i18n.changeLanguage("en")
                }
            >
                EN
            </button>

            <button
                onClick={() =>
                    i18n.changeLanguage("fr")
                }
            >
                FR
            </button>

        </div>

    );
}

export default LanguageSwitcher;