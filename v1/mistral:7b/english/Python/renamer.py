# ```python

import os
import shutil

# Get current working directory (where the script is run)
cwd = os.getcwd()

# Iterate over all files and directories in the current working directory
for entry in os.scandir(cwd):
    # If it's a file, rename it to the same name as the first file (assuming all files have the same name)
    if entry.is_file():
        new_name = os.listdir(cwd)[0]
        shutil.move(entry.path, cwd + '/' + new_name)

# ```

# This code will rename every existing file in the current working directory (where the script is run) to have the same name as the first file found in that directory. If there are no files in the directory, this code will raise an exception.