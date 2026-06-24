const API_URL =
    "http://localhost:8080";

export async function getScheduleByDoctorId(
    doctorId
) {

    const response = await fetch(

        `${API_URL}/schedules/doctor/${doctorId}`

    );

    return await response.json();
}