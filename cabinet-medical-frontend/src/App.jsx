import { Routes, Route } from "react-router-dom";

import HomePage from "./pages/HomePage";
import AdminDashboard
    from "./pages/AdminDashboard";

import DoctorDashboard
    from "./pages/DoctorDashboard";

import AssistantDashboard
    from "./pages/AssistantDashboard";

import PatientDashboard
    from "./pages/PatientDashboard";

import "./App.css";

function App() {

    return (

        <Routes>

            <Route
                path="/"
                element={<HomePage />}
            />

            <Route
                path="/admin"
                element={<AdminDashboard />}
            />

            <Route
                path="/doctor"
                element={<DoctorDashboard />}
            />

            <Route
                path="/assistant"
                element={<AssistantDashboard />}
            />

            <Route
                path="/patient"
                element={<PatientDashboard />}
            />

        </Routes>

    );
}

export default App;