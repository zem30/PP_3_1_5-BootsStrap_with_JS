function deleteUser(id) {
    fetch("http://localhost:8080/delete/" + id, {
        method: "DELETE",
        headers: {"Content-type": "application/json"}
    })
        .then(response => {
            $("#" + id).remove();
        });
}