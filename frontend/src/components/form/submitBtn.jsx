import styles from  './submit_btn.module.scss'

const SubmitButton = ({text, type}) => {
    return (
       
            <button  className={styles.btn_form} type={type} >{text}</button>
    )
}

export default SubmitButton