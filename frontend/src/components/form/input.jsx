import React from 'react';

import styles from './input.module.scss'

const Input =  React.forwardRef(({ name, type, placeHolder, text, ...rest }, ref) => {

    return (
        <div className={styles.container_input }>
            <label htmlFor={name}>{text}</label>
            <input
                type={type}
                placeholder={placeHolder}
                name={name}
                ref={ref}
                {...rest}
            />
            
        </div>

    )
})

export default Input;