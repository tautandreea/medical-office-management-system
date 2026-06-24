import {

    useTranslation

} from "react-i18next";

import "../styles/UserList.css";

function UserList({

                      users,

                      onSelect,

                      onEdit

                  }) {

    const {

        t

    } = useTranslation();

    return (

        <div className="user-panel">

            <h2>

                {t("users")}

            </h2>

            {

                users.map(

                    user => (

                        <div

                            key={user.id}

                            className="user-item"

                            onClick={() =>
                                onSelect(user)
                            }

                        >

                            <div>

                                <strong>

                                    {user.username}

                                </strong>

                                <p>

                                    {user.role}

                                </p>

                            </div>

                            <button

                                className="edit-btn"

                                onClick={(e) => {

                                    e.stopPropagation();

                                    onEdit(user);

                                }}

                            >

                                {t("edit")}

                            </button>

                        </div>

                    )

                )

            }

        </div>

    );
}

export default UserList;