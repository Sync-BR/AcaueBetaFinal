import axios from 'axios';
import styles from './modal.module.scss'
import Input from "../form/input"
import SubmitButton from "../form/submitBtn";
import { useForm } from 'react-hook-form';
import { useState } from "react";


const Modal = ({ isOpen, handleClose }) => {
    const { register, handleSubmit, formState: { errors }, reset } = useForm();

    const [data, setData] = useState({})

    const handleSubmitForm = async (data) => {
        try {
            reset()
            setData(data)

            handleClose();
            const url = `http://186.247.89.84:8080/AcaueBeta/webresources/generic/RegisterPopup`;

            const params = new URLSearchParams();
            params.append('name', data.name);
            params.append('surname', data.surname);
            params.append('email', data.email);

            await axios
            .post(url, params)
            .then((data) => data.config)
            .then((data) => console.log("sucesso! ", data.data))
            .catch((data) => console.error("deu ruim ", data))

        } catch (error) {
            console.error('Erro:', error);
            alert('Erro ao enviar dados. Por favor, tente novamente.');
        }
    };

    if (isOpen) {
        return (
            <div className={styles.container_modal}>
                <div className={styles.modal}>
                    <h1>Preencha Agora Este Karalho</h1>
                    <button className={styles.btn_close} onClick={() => handleClose()}>Fechar</button>
                    <form className={styles.modal_form} onSubmit={handleSubmit(handleSubmitForm)}>
                        <Input
                            name="name"
                            type="text"
                            placeholder="Nome"
                            text="Nome"
                            {...register('name', {
                                required: "Campo obrigatório",
                            })}
                        />
                        {errors.name && <p className={styles.required}>{errors.name.message}</p>}

                        <Input
                            name="surname"
                            type="text"
                            placeholder="Sobrenome"
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

