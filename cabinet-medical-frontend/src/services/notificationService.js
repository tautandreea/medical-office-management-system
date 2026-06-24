const API_URL =
    "http://localhost:8080";

export async function sendNotification(
    notification
) {

    const response =
        await fetch(

            `${API_URL}/notifications/send`,

            {
                method: "POST",

                headers: {
                    "Content-Type":
                        "application/json"
                },

                body: JSON.stringify(
                    notification
                )
            }
        );

    return await response.json();
}