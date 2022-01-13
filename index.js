const express = require('express')
const { initializeApp, applicationDefault, cert } = require('firebase-admin/app');
const { getFirestore, Timestamp, FieldValue } = require('firebase-admin/firestore');
const app = express()
app.use(express.json());
initializeApp();

const db = getFirestore();
app.get('/verify', (req,res) => {
  const docRef = db.collection('Auth').doc(req.header('username')).get();
  res.send(JSON.stringify(docRef));
  console.log("Hello World");
  console.log(req.header('username'));
  console.log(req.header('password'));
});

app.delete('/logout', (req,res) => {
  res.send(JSON.stringify({
    "Success": true
  }));
  console.log(req.header('username'));
});

app.post('/data/user', (req,res) => {
  console.log(req.body);
  res.send(JSON.stringify(req.body));
});

app.get('/data/admin', (req,res) => {
  res.send(JSON.stringify({
      "Data": [
        {
          "Region": "India",
          "Quantity": "50",
          "Purity": "100",
          "BuyingPrice": "40",
          "MarketPrice": "50",
          "Timestamp": "2001-12-20 6:30:00"
        }
      ]
  }));
});



app.listen(3000, () => console.log('Listening on port 3000..'));
  