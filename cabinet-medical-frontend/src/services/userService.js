const API_URL =
    "http://localhost:8080";

export async function getAllUsers() {

    const response =
        await fetch(

            `${API_URL}/users`

        );

    return await response.json();
}

export async function createUser(
    user
) {

    const response =
        await fetch(

            `${API_URL}/users`,

            {

                method: "POST",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body:
                    JSON.stringify(
                        user
                    )

            }

        );

    return await response.json();
}

export async function updateUser(
    user
) {

    const response =
        await fetch(

            `${API_URL}/users`,

            {

                method: "PUT",

                headers: {

                    "Content-Type":
                        "application/json"

                },

                body:
                    JSON.stringify(
                        user
                    )

            }

        );

    return await response.json();
}

export async function deleteUser(
    id
) {

    const response =
        await fetch(

            `${API_URL}/users/${id}`,

            {

                method: "DELETE"

            }

        );

    return await response.json();
}

export async function getUsersByRole(
    role
) {

    const response =
        await fetch(

            `${API_URL}/users/role/${role}`

        );

    return await response.json();
}