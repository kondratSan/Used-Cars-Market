// alert("Does it work?");



function validate()
{
    var firstName = document.form.firsName.value;
    var lastName = document.form.lastName.value;
    var email = document.form.email.value;
    var age = document.form.age.value;
    var phoneNumber = document.form.phoneNumber.value;
    var city_id= document.form.city_id.value;
    var password = document.form.password.value;

    if (firstName==null || firsName=="")
    {
        alert("First Name can't be blank");
        return false;
    }
    else if (firstName==null || firstName=="")
    {
        alert("Last Name can't be blank");
        return false;
    }
    else if (email==null || email=="")
    {
        alert("Username can't be blank");
        return false;
    }
    else if(password.length<6)
    {
        alert("Password must be at least 6 characters long.");
        return false;
    }
    else if (password!=conpassword)
    {
        alert("Confirm Password should match with the Password");
        return false;
    }
}