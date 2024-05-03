import express from 'express'

import {dirname, join} from 'path'

import { fileURLToPath } from 'url';

const app = express();
const port = process.env.PORT || 3000;

const __filename = fileURLToPath(import.meta.url)
const __dirname = dirname(__filename);

app.use(express.static(join(__dirname, 'dist')));
app.get('*', (req, res) => {
    res.sendFile(join(__dirname, 'dist', 'index.html'));
});
app.listen(port, () => {
    console.log(`Servidor está rodando em http://localhost:${port})`)
})
