function allRoles(user) {
    let rolesList = document.createElement('ul');

    for (let i = 0; i < user.roles.length; i++) {
        let role = document.createElement('li');
        role.textContent = user.roles[i].role.substring(5) + " ";
        rolesList.appendChild(role);
    }
    return rolesList;
}