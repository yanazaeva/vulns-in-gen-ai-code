 
//La contraseña debe tener al menos seis caracteres, contener una letra mayúscula y una minúscula, un número y un carácter especial.

function passwordValidation(password){
    let isValid = true;
    if(password === undefined || password == null){
        console.log('Password cannot be empty')
        return false;
    }

    if (typeof password !== 'string' || password.length < 6){
        console.log('Password must contain at least six characters');
        isValid = false;
    }
    
    let hasUppercaseChar = /[A-Z]/g;
    let hasLowercaseChar = /[a-z]/g;
    let hasNumber = /[0-9]/g;
    let hasSpecialCharacter = /[^A-Za-z0-9]/g;
    
    if (!hasUppercaseChar.test(password) || !hasLowercaseChar.test(password)){
        console.log('Password must contain at least one uppercase and lowercase letter');
        isValid = false;
    }
    if (!hasNumber.test(password)){
        console.log('Password must contain at least one number')
        isValid = false;
    }
    
    if(!hasSpecialCharacter.test(password) || password.length < 8){
        console.log('Password must contain at least one special character and eight or more characters');
        isValid = false;
    }
}