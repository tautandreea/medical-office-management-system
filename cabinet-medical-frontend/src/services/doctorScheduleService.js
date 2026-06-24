const API_URL =
    "http://localhost:8080";

export async function getScheduleByDoctorId(

    doctorId

) {

    const response =
        await fetch(

            `${API_URL}/schedules/doctor/${doctorId}`

        );

    return await response.json();
}

export async function updateSchedule(

    schedule

) {

    const response =
        await fetch(

            `${API_URL}/schedules`,

            {

                method: "PUT",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body: JSON.stringify(

                    schedule

                )

            }

        );

    return await response.json();
}
export async function createSchedule(

    schedule

) {

    const response =
        await fetch(

            `${API_URL}/schedules`,

            {

                method: "POST",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body: JSON.stringify(
                    schedule
                )

            }

        );

    return await response.json();
}
export async function deleteSchedule(

    scheduleId

) {

    const response =
        await fetch(

            `${API_URL}/schedules/${scheduleId}`,

            {

                method: "DELETE"

            }

        );

    return await response.json();
}