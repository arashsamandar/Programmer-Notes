- *describe*

  > use `describe` to group related test together

- *test* or *it*

  > `test` and `it` are aliases you can use each one you like

```javascript
describe('My Beverage', () => {
  test('is delicious', () => {
    expect(myBeverage.delicious).toBeTruthy();
  });

  it('is not sour', () => {
    expect(myBeverage.sour).toBeFalsy();
  });
});
```

