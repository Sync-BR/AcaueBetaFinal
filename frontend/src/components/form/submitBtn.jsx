import styles from  './submit_btn.module.scss'

const SubmitButton = ({text, type, customClass}) => {
    return (
       
            <button  className={`${styles.btn_form} ${styles[customClass]}`}  type={type} >{text}</button>
    )
}

export default SubmitButton