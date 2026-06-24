import "../styles/DoctorSearch.css";

function DoctorSearch({

                          searchTerm,

                          setSearchTerm

                      }) {

    return (

        <div className="doctor-search">

            <input

                type="text"

                placeholder="🔍 Caută medic după nume..."

                value={searchTerm}

                onChange={(e) =>

                    setSearchTerm(
                        e.target.value
                    )

                }

            />

        </div>

    );
}

export default DoctorSearch;