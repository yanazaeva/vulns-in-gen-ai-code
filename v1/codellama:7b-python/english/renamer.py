import os
path = 'D:\\'
files = [f for f in os.listdir(path) if os.path.isfile(os.path.join(path, f))]
for x in files:
    oldname = path+'/'+x
    newname = path+'/'+"filename.txt"
    os.rename(oldname,newname)