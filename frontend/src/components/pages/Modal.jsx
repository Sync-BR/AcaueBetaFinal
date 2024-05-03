import axios from 'axios';
import { useForm } from 'react-hook-form';
import { IoMdClose } from "react-icons/io";
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

import styles from './modal.module.scss'
import Input from "../form/input"
import SubmitButton from "../form/submitBtn";

const Modal = ({ isOpen, handleClose }) => {
    const { register, handleSubmit, formState: { errors }, reset } = useForm();


    const handleSubmitForm = async (data) => {
        try {
            reset()

            handleClose();
            const url = `http://syncbackend.ddns.net:8080/acaueBeta-1.0-SNAPSHOT/webresources/generic/RegisterPopup`;

            const params = new URLSearchParams();
            params.append('name', data.name);
            params.append('surname', data.surname);
            params.append('email', data.email);

            await axios
                .post(url, params)
                .then((data) => {
                    console.log('sucesso!', data.config)
                    toast.success('Sucesso!!')

                })
                .catch((err) => {
                    console.log('error Modal',  err.response.data)
                    toast.error("Erro ao enviar mensagem")
                })

        } catch (error) {
            console.error('Erro:', error);
            alert('Erro ao enviar dados. Por favor, tente novamente.');
        }
    };

    if (isOpen) {
        return (
            <div className={styles.container_modal}>
                <div className={styles.modal}>
                    <h1>Preencha os Campos</h1>
                    <button className={styles.btn_close} onClick={() => handleClose()}><IoMdClose size={20} /></button>
                    <form className={styles.modal_form} onSubmit={handleSubmit(handleSubmitForm)}>
                        <Input
                            name="name"
                            type="text"
                            placeholder="Digite seu Nome"
                            text="Nome"
                            {...register('name', {
                                required: "Campo obrigatório",
                            })}
                        />
                        {errors.name && <p className={styles.required}>{errors.name.message}</p>}

                        <Input
                            name="surname"
                            type="text"
                            placeholder="Digite o Sobrenome"
                            text="Sobrenome"
                            {...register('surname', {
                                required: "Campo obrigatório",

                            })}
                        />
                        {errors.surname && <p className={styles.required}>{errors.surname.message}</p>}
                        <Input
                            name="email"
                            type="email"
                            placeholder="Digite o E-mail"
                            text="E-mail"
                            {...register('email', {
                                required: "Campo obrigatório",
                            })}
                        />
                        {errors.email && <p className={styles.required}>{errors.email.message}</p>}

                        <SubmitButton
                            text="Enviar"
                            type="submit"
                            customClass="margin_top"
                        />
                    </form>
                </div>
            </div>
        )
    }

    return null

}

export default Modal

