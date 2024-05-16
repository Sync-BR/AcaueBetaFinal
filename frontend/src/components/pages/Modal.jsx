import axios from 'axios';
import { useForm } from 'react-hook-form';
import { IoMdClose } from "react-icons/io";
import { toast } from 'react-toastify';
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
            const url = `https://cflceb.hospedagemelastica.com.br/Painel/webresources/generic/RegisterPopup`;

            const params = new URLSearchParams();
            params.append('name', data.name);
            params.append('surname', data.surname);
            params.append('email', data.email);

            try {
                const response = await axios.post(url, params)
                console.log("data on", response)
                console.log("sucesso!", response.config)
                toast.success('Contato enviado com sucesso!',{
                    position: 'top-left',
                    closeOnClick: false,
                    theme: "dark",
    
                });
            } catch (err) {
                console.error('Conexão Falhou', err)
                toast.error('Ocorreu um erro ao enviar o contato!')
            }
        } catch (error) {
            console.error('Erro:', error);
            toast.error('Erro ao enviar dados. Por favor, tente novamente.');
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

