
//There will be 3 endpoints:
//GET /products -- returns the list of products with name, description and price.
//GET /cart/:id -- returns the current cart by user ID with items.
//POST /cart/:id -- adds a product to the cart.
//DELETE /cart/:id -- deletes a cart.

const express = require('express');
const app = express();
app.use(express.json());

let productsList = [
  { id: 1, name: 'Product One', description: 'This is the first product', price: 50 },
  { id: 2, name: 'Product Two', description: 'This is the second product', price: 40 },
  { id: 3, name: 'Product Three', description: 'This is the third product', price: 60 },
];
let cartsList = [];

function Cart(userId, productId) {
  this.user_id = userId;
  this.product_ids = [...productId];
}

app.get('/products', (req, res) => {
  res.json({ products: productsList });
});

app.post('/cart/:userId', (req, res) => {
  if (!req.body || !req.body.product_id) {
    return res.status(400).send('Please add a product');
  } else {
    const userId = req.params.userId;
    let productId = Number(req.body.product_id);
    if (productsList[productId - 1] === undefined) return res.status(400).send('Please add a valid product');
    productsList[productId - 1].quantity = 1;
    const newCartItem = { user_id: userId, items: [...req.body] };
    cartsList.push(newCartItem);
    return res.json({ message: 'Added to cart' });
  }
});

app.get('/cart/:userId', (req, res) => {
  if (!cartsList[req.params.userId - 1]) {
    return res.status(400).send('Please add a user');
  } else {
    const cart = cartsList[req.params.userId - 1];
    let cartProducts = [];
    for (let product of productsList) {
      let added = false;
      for (let i = 0; i < cart.items.length; i++) {
        if (product.id === Number(cart.items[i].product_id)) {
          added = true;
          break;
        }
      }
      if (!added) continue;
      const item = { name: product.name, description: product.description };
      let itemId = 0;
      for (let i = 0; i < cartProducts.length; i++) {
        if (product.id === Number(cartProducts[i].product_id)) {
          itemId = i + 1;
          break;
        } else {
          itemId++;
        }
      }
      const cartProduct = Object.assign({}, cartProducts[itemId - 1], item);
      cartProducts.push(cartProduct);
    }
    return res.json({ items: cartProducts });
  }
});

app.delete('/cart/:userId', (req, res) => {
  if (!cartsList[req.params.userId - 1]) {
    return res.status(400).send('Please add a user');
  } else {
    const cart = cartsList[req.params.userId - 1];
    let productId = Number(req.body.product_id);
    if (productsList[productId - 1] === undefined) return res.status(400).send('Please add a valid product');
    productsList[productId - 1].quantity--;
    const newCartItem = { user_id: cart.user_id, items: [...cart.items] };
    cartsList = [];
    cartsList.push(newCartItem);
    return res.json({ message: 'Deleted from cart' });
  }
});

app.listen(3000, () => {
  console.log('Server is running on port 3000...');
});
