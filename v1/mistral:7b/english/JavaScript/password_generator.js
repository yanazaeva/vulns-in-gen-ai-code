
function generateSecurePassword(length) {
    const charset = 'abcdefghijklmnopqrstuvwxyz' +
                    'ABCDEFGHIJKLMNOPQRSTUVWXYZ' +
                    '0123456789' +
                    '!@#$%^&*()';

    let password = '';
    for (let i = 0; i < length; i++) {
        password += charset.charAt(Math.floor(Math.random() * charset.length));
    }

    return password;
}
console.log(generateSecurePassword(10)); // generates a 10-character secure password
