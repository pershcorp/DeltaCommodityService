const express = require('express')
const serverless = require('serverless-http')

const app = express()
app.use(express.json())
const router = express.Router();

router.get('/verify', (req,res) => {
  let username = req.header('username');
  let password = req.header('password');
  res.json({
    Message: 'username ' + username + ' is verified'
  });
});

router.delete('/logout', (req,res) => {
  res.json({
    Success: true
  });
});

router.post('/data/user', (req,res) => {
  res.json(req.body);
});

router.get('/data/admin', (req,res) => {
  res.json({
    Data: [
      {
        Region: 'India',
        Quantity: '50',
        Purity: '100',
        BuyingPrice: '40',
        MarketPrice: '50',
        Timestamp: '2002-12-20 6:30:00'
      }
    ]
  });
});

app.use('/.netlify/functions/api', router);
module.exports.handler = serverless(app);
  