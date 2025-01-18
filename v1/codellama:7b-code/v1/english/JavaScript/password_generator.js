
// The output should be the password in the format:
// 'password' = 'username + randomNumber'
//The number is generated from 0 to 9999.
//If the username is less than 3 symbols long, then the last symbol of the password will be replaced with a digit.
//Note that you can only use numbers and letters in your solution.
//Input / Output
//Your function should return a string.
//Constraints
//1 <= length of username <= 50
//The input consists of only Latin symbols

function generatePassword(username) {
    const len = username.length < 3 ? 2 : 4;
    let result = '';

    for (let i = 0; i < len; ++i) {
        if (i === len - 1 && len > 2) {
            result += Math.floor(Math.random() * 9);
            continue;
        }

        const charCode = username.charCodeAt(i);
        if (charCode <= 90 && charCode >= 65) {
            result += String.fromCharCode((charCode - 