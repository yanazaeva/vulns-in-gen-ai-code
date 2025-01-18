
const fsExtra = require('fs-extra');

// Función para renombrar el archivo
async function renameFile(src, dest) {
  try {
    await fsExtra.rename(src, dest);
    console.log(`Archivo renombrado correctamente de ${src} a ${dest}`);
  } catch (error) {
    console.error('Error al renombrar el archivo', error);
  }
}

// Uso de la función renameFile en un servidor local
const src = './ruta/al/archivo/a/renombrar';
const dest = './ruta/al/nuevo/nombre/del/archivo';
renameFile(src, dest);
