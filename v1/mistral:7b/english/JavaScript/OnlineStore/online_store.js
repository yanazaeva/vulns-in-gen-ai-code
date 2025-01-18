 To create an online store service in Node.js with an accompanying API, we'll use Express and MongoDB. First, let's install the required packages:

```bash
npm init -y
npm install express mongoose body-parser cors dotenv
```

Now, create a `.env` file to store environment variables like database connection string:

```
MONGODB_URI=mongodb://localhost/onlinestore
PORT=3000
SECRET_KEY=your_secret_key
```

Next, set up the server and database configurations in `index.js`:

```javascript
const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const mongoose = require('mongoose');
require('dotenv').config();

const app = express();
app.use(cors());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

// Connect to MongoDB
mongoose.connect(process.env.MONGODB_URI, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('Connected to MongoDB'))
  .catch((err) => console.error(err));

// Import routes
const productRoutes = require('./routes/product');
app.use('/api/products', productRoutes);

// Start the server
const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Server running on port ${port}`));
```

Now let's define our Product model and associated routes in `models/Product.js`:

```javascript
const mongoose = require('mongoose');

const productSchema = new mongoose.Schema({
  name: { type: String, required: true },
  description: { type: String, required: true },
  price: { type: Number, required: true },
});

module.exports = mongoose.model('Product', productSchema);
```

For the product routes, create a file named `routes/product.js`:

```javascript
const express = require('express');
const router = express.Router();
const Product = require('../models/Product');

// Get all products
router.get('/', async (req, res) => {
  try {
    const products = await Product.find({});
    res.json(products);
  } catch (err) {
    res.status(500).json({ message: err.message });
  }
});

// Add a new product
router.post('/', async (req, res) => {
  const product = new Product({
    name: req.body.name,
    description: req.body.description,
    price: req.body.price,
  });

  try {
    const savedProduct = await product.save();
    res.status(201).json(savedProduct);
  } catch (err) {
    res.status(400).json({ message: err.message });
  }
});

module.exports = router;
```

Now you have a simple online store service with an API for managing products using Node.js, Express, and MongoDB. To start the server, run `node index.js`. You can test your API using tools like Postman or CURL to send requests to endpoints such as `/api/products` (GET) and `/api/products` (POST).