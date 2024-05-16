
import React from 'react'

import styles from './input.module.scss'
const TextArea = React.forwardRef(({ name, text, placeHolder, ...rest }, ref) => {

    return (
        <div className={styles.container_input }>
            <label htmlFor={name}>{text}</label>
            <textarea
                rows="4"
                placeholder={placeHolder}
                name={name}
                ref={ref}
                {...rest}
            ></textarea>
        </div>
    )
})

export default TextArea