pub struct Solution;

impl Solution {
    pub fn max_sub_array(nums: Vec<i32>) -> i32 {
        nums.iter()
            .scan(i32::MIN, |state, &x| {
                *state = if *state <= 0 { x } else { *state + x };
                Some(*state)
            })
            .inspect(|x| println!("{}", x))
            .max()
            .unwrap()
    }
}

fn main() {
    println!("{}", Solution::max_sub_array(vec![-2,1,-3,4,-1,2,1,-5,4]))
}