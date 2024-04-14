import express  from "express";
import { addContact, addEmail } from "../controllers/user.js"

const router = express.Router();

router.post( " /contactAdd ", addContact )

router.post("/addEmail", addEmail);


export default router 