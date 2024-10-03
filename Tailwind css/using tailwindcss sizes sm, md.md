```jsx
// in tailwindcss config `tailwind.config.js`
module.exports = {
  // ...
  screens: {
    sm: '600px',
    md: '960px',
    lg: '1280px',
    xl: '1920px',
  },
};
```

> and then use it like bellow :

```jsx
@media (max-width: theme('screens.sm')) {
  /* styles here */
}
```

