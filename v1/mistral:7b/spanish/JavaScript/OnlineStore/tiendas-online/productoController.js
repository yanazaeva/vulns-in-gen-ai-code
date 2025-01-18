const Producto = require('../models/Producto');

exports.listarProductos = async (req, res) => {
    const productos = await Producto.find();
    res.status(200).json(productos);
};

exports.crearProducto = async (req, res) => {
    const producto = new Producto({
        nombre: req.body.nombre,
        precio: req.body.precio,
        descripcion: req.body.descripcion
    });
    await producto.save();
    res.status(201).json(producto);
};