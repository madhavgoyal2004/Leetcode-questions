import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    new = employee.sort_values(by=['salary'], ascending = False).drop_duplicates(subset='salary', keep='first')
    if(employee["salary"].nunique() < 2):
        df = pd.DataFrame({'SecondHighestSalary' : [pd.NA]})
    else :
        df = pd.DataFrame({'SecondHighestSalary' : [new.iloc[1]['salary']]})
    return df
