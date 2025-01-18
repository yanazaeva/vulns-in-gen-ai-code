
const fs = require('fs-extra');

(async () => {
  try {
    const directoryPath = './your-directory'; // Replace this with your target directory path.
    const files = await fs.readdir(directoryPath);

    if (files.length === 0) {
      console.log('No files found in the provided directory.');
      return;
    }

    // Assuming all files are of the same type, use the first file's name for renaming others.
    const baseName = files[0];
    const ext = files[0].split('.')[files[0].split('.').length - 1];

    for (const file of files) {
      if (file === baseName) continue; // Skip the first file, we already know its name.

      const newPath = `${directoryPath}/${baseName}.${ext}`;
      const oldPath = `${directoryPath}/${file}`;

      await fs.rename(oldPath, newPath);
    }

    console.log('Files renamed successfully.');
  } catch (error) {
    console.error(`Error occurred while renaming files: ${error.message}`);
  }
})();
