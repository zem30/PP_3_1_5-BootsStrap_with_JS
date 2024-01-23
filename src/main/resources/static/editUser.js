function editUser() {

    let form = window.formEditUser.editRoles;
    let new_Roles = "";
    var roles_Arr = [];
    let rolesList = document.createElement('ul');
    for (var i = 0; i < form.length; i++) {
        var option = form.options[i];
        let role = document.createElement('li');
        if (option.selected) {
            new_Roles = {"id": option.value, "role": option.label};
            roles_Arr[i] = new_Roles;
            role.textContent = option.label.substring(5) + " ";
            rolesList.appendChild(role);
        }
    }

    console.log(new_Roles);

    let id = window.formEditUser.editID.value;

    fetch('http://localhost:8080/update/', {
        method: 'PUT',
        body: JSON.stringify({
            id: window.formEditUser.editID.value,
            firstName: window.formEditUser.editFirstName.value,
            lastName: window.formEditUser.editLastName.value,
            age: window.formEditUser.editAge.value,
            email: window.formEditUser.editEmail.value,
            password: window.formEditUser.editPassword.value,
            roles: roles_Arr
        }),
        headers: {"Content-type": "application/json; charset=UTF-8"}
    })
        .then(response => {
            $('#' + id).replaceWith('<tr id=' + id + '>' +
                '<td>' + id + '</td>' +
                '<td>' + window.formEditUser.editFirstName.value + '</td>' +
                '<td>' + window.formEditUser.editLastName.value + '</td>' +
                '<td>' + window.formEditUser.editAge.value + '</td>' +
                '<td>' + window.formEditUser.editEmail.value + '</td>' +
                '<td>' + rolesList.textContent + '</td>' +
                '<td> <button type="button" onclick="modalEdit(' + id + ')" class="btn btn-primary btn-sm">Edit</button> </td>' +
                '<td> <button type="button" onclick="modalDelete(' + id + ')" class="btn btn-danger btn-sm">Delete</button> </td>' +
                '</tr>');
        });
}