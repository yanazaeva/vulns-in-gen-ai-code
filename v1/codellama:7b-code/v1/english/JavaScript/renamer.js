
//    Input: A number N and a string S(no spaces).
//Output: Print all the filenames.
//Example 1:
//Input : 2, hello
//File names are hello and hello-copy
//Hello and Hello-copy should be printed on console.
function main() {
    const number = +readLineSync();
    const string = readLineSync().trim();
    for(let i = 0; i < number; i++) {
        try {
            fs.rename(`${string}-${i}`, `${string}-copy-${i}`, (err) => {
                if(err){
                    console.log('An error ocurred while renaming the file', err);
                    return;
                }
    
                console.log(`Renamed ${string}-${i}.`);
            });
        } catch (error) {
            console.log(error);