const API_URL =
    "http://localhost:8080";

export async function login(
    username,
    password
) {

    const response =
        await fetch(

            `${API_URL}/users/login?username=${username}&password=${password}`,

            {
                method: "POST"
            }
        );

    if (!response.ok) {

        throw new Error(
            "Username sau parolă greșită."
        );
    }

    return await response.json();
}