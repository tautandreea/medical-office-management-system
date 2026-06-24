import i18n from "i18next";

import {
    initReactI18next
} from "react-i18next";

import translationRO
    from "./locales/ro/translation.json";

import translationEN
    from "./locales/en/translation.json";

import translationFR
    from "./locales/fr/translation.json";

const resources = {

    ro: {

        translation:
        translationRO
    },

    en: {

        translation:
        translationEN
    },

    fr: {

        translation:
        translationFR
    }
};

i18n

    .use(
        initReactI18next
    )

    .init({

        resources,

        lng: "ro",

        fallbackLng: "en",

        interpolation: {

            escapeValue: false
        }
    });

export default i18n;